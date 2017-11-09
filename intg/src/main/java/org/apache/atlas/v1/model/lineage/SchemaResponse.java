/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.atlas.v1.model.lineage;

import org.apache.atlas.v1.model.typedef.ClassTypeDefinition;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.List;
import java.util.Map;

import static org.codehaus.jackson.annotate.JsonAutoDetect.Visibility.NONE;
import static org.codehaus.jackson.annotate.JsonAutoDetect.Visibility.PUBLIC_ONLY;

@JsonAutoDetect(getterVisibility = PUBLIC_ONLY, setterVisibility = PUBLIC_ONLY, fieldVisibility = NONE)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SchemaResponse {
    private String        requestId;
    private String        tableName;
    private SchemaDetails results;

    public SchemaResponse() {
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(final String tableName) {
        this.tableName = tableName;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(final String requestId) {
        this.requestId = requestId;
    }

    public SchemaDetails getResults() {
        return results;
    }

    public void setResults(final SchemaDetails results) {
        this.results = results;
    }

    /**
     * Represents the column schema for a given hive table
     */
    @JsonAutoDetect(getterVisibility = PUBLIC_ONLY, setterVisibility = PUBLIC_ONLY, fieldVisibility = NONE)
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SchemaDetails {
        private String                    query;      // The DSL query representation for obtaining schema
        private ClassTypeDefinition       dataType;   // Data type of the (hive) columns
        private List<Map<String, Object>> rows;       // Column instances for the given table

        public SchemaDetails() {
        }

        public String getQuery() {
            return query;
        }

        public void setQuery(final String query) {
            this.query = query;
        }

        public ClassTypeDefinition getDataType() {
            return dataType;
        }

        public void setDataType(final ClassTypeDefinition dataType) {
            this.dataType = dataType;
        }

        public List<Map<String, Object>> getRows() {
            return rows;
        }

        public void setRows(final List<Map<String, Object>> rows) {
            this.rows = rows;
        }
    }
}
