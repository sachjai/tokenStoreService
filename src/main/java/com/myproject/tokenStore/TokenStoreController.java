package com.myproject.tokenStore;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class TokenStoreController {
	
	@Autowired
	private TokenRepository tokenRepository;
	
	
	@GetMapping(value="/getTokens")
	public ResponseEntity<Iterable<Token>> getTokens()
	{
		Iterable<Token> listToken = tokenRepository.findAll();
		return new ResponseEntity<Iterable<Token>>(listToken, HttpStatus.OK);
	}
	
	@PostMapping(value="/addToken")
	public ResponseEntity<Token> addToken(@RequestBody Token token)
	{
		List<Token> listToken = tokenRepository.findByUsername(token.getUsername());
		tokenRepository.deleteAll(listToken);
		
		Token latestToken = tokenRepository.save(token);
		return new ResponseEntity<Token>(latestToken, HttpStatus.OK);
	}
	
	@PostMapping(value="/validateToken")
	public ResponseEntity<TokenValidity> validateToken(@RequestBody Token token)
	{
		List<Token> listToken = tokenRepository.findByUsername(token.getUsername());
		TokenValidity tokenValidity = new TokenValidity(false);
		for(Token t : listToken)
		{
			if(t.getToken().equals(token.getToken()))
			{
				tokenValidity.setTokenValid(true);
			}					
					
		}
		return new ResponseEntity<TokenValidity>(tokenValidity, HttpStatus.OK); 
	}
	
}
