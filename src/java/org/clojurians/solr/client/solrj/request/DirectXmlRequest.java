/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.clojurians.solr.client.solrj.request;

import org.clojurians.solr.client.solrj.SolrClient;
import org.clojurians.solr.client.solrj.SolrRequest;
import org.clojurians.solr.client.solrj.response.UpdateResponse;
import org.clojurians.solr.client.solrj.util.ClientUtils;
import org.clojurians.solr.common.params.SolrParams;
import org.clojurians.solr.common.util.ContentStream;

import java.util.Collection;

/**
 * Send arbitrary XML to a request handler
 * 
 *
 * @since solr 1.3
 */
public class DirectXmlRequest extends SolrRequest<UpdateResponse> implements IsUpdateRequest {

  final String xml;
  private SolrParams params;
  
  public DirectXmlRequest( String path, String body )
  {
    super( METHOD.POST, path );
    xml = body;
  }

  @Override
  public Collection<ContentStream> getContentStreams() {
    return ClientUtils.toContentStreams( xml, ClientUtils.TEXT_XML );
  }

  @Override
  protected UpdateResponse createResponse(SolrClient client) {
    return new UpdateResponse();
  }

  @Override
  public SolrParams getParams() {
    return params;
  }


  public void setParams(SolrParams params) {
    this.params = params;
  }

}
