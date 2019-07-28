/*
 * Copyright 2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance
 * with the License. A copy of the License is located at
 *
 * http://aws.amazon.com/apache2.0/
 *
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES
 * OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package org.apache.mxnet.nn;

import org.apache.mxnet.nn.core.MxLinear;
import software.amazon.ai.nn.NNIndex;
import software.amazon.ai.nn.core.Linear;

public class MxNNIndex extends NNIndex {

    /** {@inheritDoc} */
    @Override
    public Linear linear(long outChannels, boolean bias) {
        return new MxLinear(outChannels, bias);
    }
}