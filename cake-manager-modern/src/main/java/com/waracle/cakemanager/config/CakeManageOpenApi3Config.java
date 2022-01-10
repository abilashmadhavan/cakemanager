package com.waracle.cakemanager.config;

/**
 * Open api documentation class file
 * @author Abilash
 */
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.OAuthScope;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@OpenAPIDefinition(info = @Info(title = "Cake Manager", description = "Api's for cake manager application", version = "1.0"))
@SecurityScheme(name = "security_auth", type = SecuritySchemeType.OAUTH2, flows = @OAuthFlows(authorizationCode = @OAuthFlow(authorizationUrl = "${springdoc.oAuthFlow.authorizationUrl}", tokenUrl = "${springdoc.oAuthFlow.tokenUrl}", scopes = {
		@OAuthScope(name = "openid", description = "openid"), @OAuthScope(name = "read", description = "read scope"),
		@OAuthScope(name = "write", description = "write scope"), })))
public class CakeManageOpenApi3Config {
}