/**
 * 
 */
package com.ibm.ro.tm.apprenticeship.poll.metter.entity;

import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.SortNatural;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author O09860826
 *
 */
@Entity
public class Role implements Comparable<Role> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String name;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "role_user", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	@SortNatural
	@JsonIgnoreProperties("roles")
	private SortedSet<User> users = new TreeSet<User>();

	protected Role() {

	}

	public Role(String name) {
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	public void addUser(User user) {
		users.add(user);
		user.getRoles().add(this);

	}

	public void removeUser(User user) {
		users.remove(user);
		user.getRoles().remove(this);
	}

	/**
	 * @return the users
	 */
	public SortedSet<User> getUsers() {
		return users;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "(" + this.id + ", " + this.name + ")";
	}

	@Override
	public int compareTo(Role o) {
		int result = 0;
		if (o != null) {
			if (id != null) {
				result = id.compareTo(o.getId());
			} else if (o.getId() != null) {
				result = 1;
			} else {
				result = 0;
			}
		} else {
			result = -1;
		}
		return result;
	}

}
