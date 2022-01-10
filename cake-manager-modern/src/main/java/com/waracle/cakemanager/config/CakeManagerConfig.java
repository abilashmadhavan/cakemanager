package com.waracle.cakemanager.config;

import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * The cake manager config file with component scans
 * 
 * @author Abilash
 *
 */
@ComponentScan(value = {"com.waracle.cakemanager.service","com.waracle.cakemanager.mapper"})
public class CakeManagerConfig {

}
