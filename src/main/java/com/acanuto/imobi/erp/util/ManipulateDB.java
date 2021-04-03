package com.acanuto.imobi.erp.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

@Component
public class ManipulateDB {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<HashMap<String, Object>> select(String sql) {

		List<HashMap<String, Object>> hashMaps = new ArrayList<>();

		return jdbcTemplate.query(sql, new ResultSetExtractor<List<HashMap<String, Object>>>() {

			@Override
			public List<HashMap<String, Object>> extractData(ResultSet rs) throws SQLException, DataAccessException {
				ResultSetMetaData metaData = rs.getMetaData();

				HashMap<String, Object> hashMap = new HashMap<>();

				for (int i = 0; i < metaData.getColumnCount(); i++) {
					hashMap.put(metaData.getColumnLabel(i), rs.getObject(i));
				}

				hashMaps.add(hashMap);

				return hashMaps;

			}
		});

	}

	public Object getField(String sql) {
		return jdbcTemplate.query(sql, new ResultSetExtractor<Object>() {
			@Override
			public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
				Object field = null;
				if (rs.next()) {
					field = rs.getObject(1);
				}
				return field;
			}
		});

	}	
	

}
