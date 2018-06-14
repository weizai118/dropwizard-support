/*
 * Copyright (c) 2018-present Sonatype, Inc. All rights reserved.
 *
 * This program is licensed to you under the Apache License Version 2.0,
 * and you may not use this file except in compliance with the Apache License Version 2.0.
 * You may obtain a copy of the Apache License Version 2.0 at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the Apache License Version 2.0 is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Apache License Version 2.0 for the specific language governing permissions and limitations there under.
 */
package com.sonatype.ossindex.dropwizard.internal;

import com.google.inject.AbstractModule;
import io.dropwizard.Configuration;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Adds bindings for {@link Configuration}.
 *
 * @since ???
 */
public class ConfigurationModule
    extends AbstractModule
{
  private final Configuration configuration;

  public ConfigurationModule(final Configuration configuration) {
    this.configuration = checkNotNull(configuration);
  }

  @SuppressWarnings("unchecked")
  @Override
  protected void configure() {
    bind((Class) configuration.getClass()).toInstance(configuration);
  }
}