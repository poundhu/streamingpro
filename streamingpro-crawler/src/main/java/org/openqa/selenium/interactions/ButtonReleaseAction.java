/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// Licensed to the Software Freedom Conservancy (SFC) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The SFC licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package org.openqa.selenium.interactions;

import com.google.common.collect.ImmutableList;
import org.openqa.selenium.interactions.internal.Locatable;
import org.openqa.selenium.interactions.internal.MouseAction;

import java.util.List;

/**
 * Releases the left mouse button
 *
 * @deprecated Use {@link Actions#release()}
 */
@Deprecated
public class ButtonReleaseAction extends MouseAction implements Action {

  public ButtonReleaseAction(Mouse mouse, Locatable locationProvider) {
    super(mouse, locationProvider);
  }

  /**
   * Releases the mouse button currently left held. This action can be called for an element
   * different than the one ClickAndHoldAction was called for. However, if this action is performed
   * out of sequence (without holding down the mouse button, for example) the results will be
   * different between browsers.
   */
  public void perform() {
    moveToLocation();
    mouse.mouseUp(getActionLocation());
  }

  @Override
  public List<Interaction> asInteractions(PointerInput mouse, KeyInput keyboard) {
    ImmutableList.Builder<Interaction> interactions = ImmutableList.builder();

    moveToLocation(mouse, interactions);
    interactions.add(mouse.createPointerUp(Button.LEFT.asArg()));

    return interactions.build();
  }
}
