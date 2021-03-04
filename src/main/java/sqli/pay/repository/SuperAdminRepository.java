package sqli.pay.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import sqli.pay.domain.Admin;

public interface SuperAdminRepository  extends MongoRepository<Admin, Long> {

}

