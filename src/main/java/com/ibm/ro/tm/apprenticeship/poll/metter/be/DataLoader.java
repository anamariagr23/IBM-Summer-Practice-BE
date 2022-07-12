/**
 * 
 */
package com.ibm.ro.tm.apprenticeship.poll.metter.be;

import java.util.logging.Logger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Role;
import com.ibm.ro.tm.apprenticeship.poll.metter.entity.User;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.RoleRepository;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.UserRepository;

/**
 * @author O09860826
 *
 */
@Configuration
class DataLoader {

	private static final Logger logger = Logger.getLogger(DataLoader.class.getName());

	@Bean
	CommandLineRunner databaseInitializer(UserRepository userRepository, RoleRepository roleRepository) {
		return args -> {
			
			User yoda = new User("Yoda");
			User luke = new User("Luke");
			User leia = new User("Leia");
			User obi = new User("Obi");
			User vader = new User("Vader");
			User kylo = new User("Kylo");
			User rey = new User("Rey");

			Role master = new Role("master");

			Role padawan = new Role("padawan");

			logger.info("loading user:" + userRepository.save(yoda));
			logger.info("loading user:" + userRepository.save(obi));
			logger.info("loading user:" + userRepository.save(vader));
			logger.info("loading user:" + userRepository.save(luke));
			logger.info("loading user:" + userRepository.save(leia));
			logger.info("loading user:" + userRepository.save(kylo));
			logger.info("loading user:" + userRepository.save(rey));
			roleRepository.save(master);
			roleRepository.save(padawan);

			master.addUser(yoda);
			master.addUser(luke);
			master.addUser(obi);
			master.addUser(vader);

			padawan.addUser(rey);
			padawan.addUser(luke);
			padawan.addUser(leia);
			padawan.addUser(obi);
			padawan.addUser(vader);
			padawan.addUser(kylo);
			padawan.addUser(rey);

			roleRepository.save(master);
			roleRepository.save(padawan);

		};
	}

}
