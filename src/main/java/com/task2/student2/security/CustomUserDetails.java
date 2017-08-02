package com.task2.student2.security;

/*
public class CustomUserDetails extends User implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	private List<String> userRoles;
	

	public CustomUserDetails(User user, List<String> userRoles){
		super(user);
		this.userRoles=userRoles;
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		String roles= StringUtils.collectionToCommaDelimitedString(userRoles);
		return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}


	@Override
	public String getUsername() {
		return super.getUserName();
	}


}*/
