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
package org.sonatype.goodies.dropwizard.rules;

import javax.annotation.Nullable;
import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import io.dropwizard.jackson.Discoverable;

/**
 * Request rule.
 *
 * @since ???
 */
@JsonTypeInfo(use = Id.NAME, property = "type")
public interface RequestRule
  extends Discoverable
{
  /**
   * Evaluate request.
   *
   * @return Result to apply; or {@code null} to continue with other rule-evaluations.
   */
  @Nullable
  RequestRuleResult evaluate(HttpServletRequest request);
}
