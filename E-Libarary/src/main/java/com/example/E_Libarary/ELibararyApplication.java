package com.example.E_Libarary;

import com.example.E_Libarary.models.Admin;
import com.example.E_Libarary.models.MyUser;
import com.example.E_Libarary.models.Student;
import com.example.E_Libarary.models.enums.AccountStatus;
import com.example.E_Libarary.repository.AdminRepository;
import com.example.E_Libarary.repository.MyUserRepository;
import com.example.E_Libarary.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.example.E_Libarary.constant.ApplicationConstant.ADMIN_AUTHORITY;

@SpringBootApplication
public class ELibararyApplication implements CommandLineRunner {
@Autowired
	PasswordEncoder passwordEncoder;

@Autowired
	MyUserRepository myUserRepository;
@Autowired
	AdminRepository adminRepository;
@Autowired
	StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(ELibararyApplication.class, args);
	}

	@Override
	public void run(String... args) {

//		MyUser user1= MyUser.builder()
//				.username("krishna").password(passwordEncoder.encode("krishna123"))
//				.authority(ADMIN_AUTHORITY)
//				.build();
//		user1=myUserRepository.save(user1);
//
//		Admin admin=Admin.builder()
//				.age(45).name("krishan Singh")
//				.myUser(user1).build();
// adminRepository.save(admin);
//
//   MyUser user2=MyUser.builder()
//		   .username("radha").password(passwordEncoder.encode("radha123"))
//		   .authority(ADMIN_AUTHORITY)
//		   .build();
//   user2=myUserRepository.save(user2);
//
//		Student student=Student.builder()
//				.name("radha").email("radha@gmail.com")
//				.accountStatus(AccountStatus.ACTIVE)
//				.phone_no(Long.valueOf("9005780950")).myUser(user2)
//				.build();
//		studentRepository.save(student);
	}
}
