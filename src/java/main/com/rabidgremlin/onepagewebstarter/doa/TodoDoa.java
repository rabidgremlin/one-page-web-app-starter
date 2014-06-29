/* 
  Licensed to the Apache Software Foundation (ASF) under one or more
  contributor license agreements.  See the NOTICE file distributed with
  this work for additional information regarding copyright ownership.
  The ASF licenses this file to You under the Apache License, Version 2.0
  (the "License"); you may not use this file except in compliance with
  the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
 */

package com.rabidgremlin.onepagewebstarter.doa;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.google.inject.Provider;
import com.rabidgremlin.onepagewebstarter.entity.Todo;

public class TodoDoa
{
  private Provider<EntityManager> emProvider;

  @Inject
  public TodoDoa(Provider<EntityManager> emProvider)
  {
	System.out.println("Created DOA. em:" + emProvider);
	this.emProvider = emProvider;
  }

  private EntityManager getEntityManager()
  {
	return emProvider.get();
  }

  public List<Todo> getAll()
  {
	return getEntityManager().createQuery("SELECT t FROM Todo t", Todo.class).getResultList();
  }

  public Todo getTodo(String id)
  {

	return getEntityManager().find(Todo.class, id);
  }

  public boolean deleteTodo(String id)
  {
	getEntityManager().remove(getTodo(id));

	return true;
  }

  public void saveTodo(Todo todo)
  {

	if (todo.getId() == null)
	{
	  todo.setId(UUID.randomUUID().toString());
	}

	getEntityManager().persist(todo);

  }
}
