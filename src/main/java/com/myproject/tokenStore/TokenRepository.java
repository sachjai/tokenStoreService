package com.myproject.tokenStore;

import org.springframework.data.repository.CrudRepository;
import java.lang.String;
import com.myproject.tokenStore.Token;
import java.util.List;

public interface TokenRepository extends CrudRepository<Token, Integer>{	

	List<Token> findByUsername(String username);

}
