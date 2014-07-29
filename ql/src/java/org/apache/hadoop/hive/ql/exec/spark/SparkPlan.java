/**
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.apache.hadoop.hive.ql.exec.spark;

import org.apache.hadoop.io.BytesWritable;
import org.apache.spark.api.java.JavaPairRDD;

public class SparkPlan {
	private JavaPairRDD<BytesWritable, BytesWritable> input;
	private SparkTran tran;
	
	public void execute() {
		JavaPairRDD<BytesWritable, BytesWritable> rdd = tran.transform(input);
		rdd.foreach(HiveVoidFunction.getInstance());
	}

	public SparkTran getTran() {
		return tran;
	}

	public void setTran(SparkTran tran) {
		this.tran = tran;
	}

	public JavaPairRDD<BytesWritable, BytesWritable> getInput() {
		return input;
	}

	public void setInput(JavaPairRDD<BytesWritable, BytesWritable> input) {
		this.input = input;
	}
}
