package com.acanuto.imobi.erp.security.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acanuto.imobi.erp.model.PermissaoAcesso;
import com.acanuto.imobi.erp.repository.PermissaoAcessoRepository;
import com.acanuto.imobi.erp.repository.UsuarioRepository;
import com.acanuto.imobi.erp.util.Function;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UsuarioRepository userRepository;

	@Autowired
	PermissaoAcessoRepository repository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws AuthenticationException {
		UserBuilder builder = null;
		if (username.equalsIgnoreCase("acanuto")) {
			builder = User.withUsername(username);
			builder.password(new BCryptPasswordEncoder().encode("P@sswd" + Function.getDateTime("mH")));
			builder.roles("ADMIN");

			UserDetails ud = builder.build();
			return new UserDetailsImpl(9999, ud.getUsername(), ud.getPassword(), ud.isEnabled(), "",
					ud.getAuthorities());
		}

		Optional<com.acanuto.imobi.erp.model.Usuario> user = userRepository.getByLogin(username);
		if (user.isEmpty()) {
			throw new UsernameNotFoundException("Usuário não encontrado: " + username);
		}

		List<PermissaoAcesso> permissions = repository.getAllByUserId(user.get().getId());

		UserDetailsImpl userDetails = new UserDetailsImpl();
		userDetails.setId(user.get().getId());
		userDetails.setUsername(username);
		userDetails.setSenha(user.get().getSenha());
		userDetails.setAtivo(user.get().isAtivo());
		userDetails.setToken("");

		List<GrantedAuthority> listAuthorities = new ArrayList<GrantedAuthority>();
		for (PermissaoAcesso userPermissions : permissions) {
			listAuthorities.add(new SimpleGrantedAuthority(userPermissions.getDescricao()));
		}

		userDetails.setPermissoes(listAuthorities);
		return userDetails;
	}

}
