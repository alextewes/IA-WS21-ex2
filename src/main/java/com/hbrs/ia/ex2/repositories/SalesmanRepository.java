package com.hbrs.ia.ex2.repositories;

import com.hbrs.ia.ex2.model.Salesman;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

//MongoCollection
//localhost:8080/swagger-ui.html
public interface SalesmanRepository extends MongoRepository<Salesman, String> {
    Salesman findSalesmanBySid(int sid);
    /*@Query("{'sid': ?}")
    Salesman(){}*/
}

    /*public List<SalesmanBO> querySalesman(String attribute, String key) {
        MongoCollection<Document> personalCollection = this.getPersonalCollection();
        BasicDBObject query = new BasicDBObject();
        if(key.equals("salesmanId")){
            query.put("_id", new ObjectId(attribute));
        } else {
            query.put(key, attribute);
        }
        FindIterable<Document> salesmen = personalCollection.find(query, Document.class);
        List<SalesmanBO> resultList = new ArrayList<>();
        for(Document doc: salesmen){
            resultList.add(SalesmanMapper.mapDocumentToBO(doc));
        }
        return resultList;
    }*/

/* import com.mongodb.BasicDBObject;
        import com.mongodb.MongoClient;
        import com.mongodb.client.FindIterable;
        import com.mongodb.client.MongoCollection;
        import com.mongodb.client.MongoDatabase;*/