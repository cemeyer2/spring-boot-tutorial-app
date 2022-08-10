/*
 * Copyright (c) 2017, Civitas Learning Incorporated.
 * All Rights Reserved.
 *
 * This software is protected by U.S. Copyright Law and International Treaties.
 * Unauthorized use, duplication, reverse engineering, any form of redistribution,
 * or use in part or in whole other than by prior, express, printed and signed license
 * for use is subject to civil and criminal prosecution.
 */

package com.example.springboottutorial.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Configuration
@ConfigurationProperties("charlie.spring.boot.tutorial")
@Validated
public class SpringBootTutorialConfiguration {

  @NotNull
  private String template;

  @NotNull
  private String defaultName;

  public String getTemplate() {
    return template;
  }

  public void setTemplate(String template) {
    this.template = template;
  }

  public String getDefaultName() {
    return defaultName;
  }

  public void setDefaultName(String defaultName) {
    this.defaultName = defaultName;
  }
}
