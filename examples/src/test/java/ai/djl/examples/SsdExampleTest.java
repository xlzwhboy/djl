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
package ai.djl.examples;

import ai.djl.examples.inference.SsdExample;
import ai.djl.modality.cv.DetectedObjects;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SsdExampleTest {

    @Test
    public void testSsdExample() {
        String[] args = {"-i", "src/test/resources/3dogs.jpg", "-c", "1", "-l", "build/logs"};

        SsdExample test = new SsdExample();
        Assert.assertTrue(test.runExample(args));
        DetectedObjects result = test.getPredictResult();
        DetectedObjects.Item best = result.best();
        Assert.assertEquals(best.getClassName(), "dog");
        Assert.assertTrue(Double.compare(best.getProbability(), 0.8) > 0);
    }
}
