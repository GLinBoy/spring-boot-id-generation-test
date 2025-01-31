```bash
docker run -i --rm -v ${PWD}:/scripts -v ${PWD}/results:/results --add-host=host.docker.internal:host-gateway \
-e ENABLE_LONGID=true \
-e ENABLE_HIBERNATEUUID=true \
-e ENABLE_JAVAUUID=true \
-e ENABLE_NANOID=true \
-e API_ENDPOINT=/api/customers \
-e LONGID_BASE_URL=http://host.docker.internal:8080 \
-e HIBERNATEUUID_BASE_URL=http://host.docker.internal:8081 \
-e JAVAUUID_BASE_URL=http://host.docker.internal:8082 \
-e NANOID_BASE_URL=http://host.docker.internal:8083 \
-e RATE=1000 \
-e TIME_UNIT=1 \
-e DURATION=30 \
-e PRE_ALLOCATED_VUS=500 \
-e MAX_VUS=1000 \
grafana/k6:0.56.0 run --out json=/results/test_results.json /scripts/IDGenerationLoadTest.js
```

```bash
docker run -i --rm -v ${PWD}:/scripts -v ${PWD}/results:/results --add-host=host.docker.internal:host-gateway \
-e ENABLE_LONGID=true \
-e ENABLE_HIBERNATEUUID=true \
-e ENABLE_JAVAUUID=true \
-e ENABLE_NANOID=true \
-e API_ENDPOINT=/api/customers \
-e LONGID_BASE_URL=http://host.docker.internal:8080 \
-e HIBERNATEUUID_BASE_URL=http://host.docker.internal:8081 \
-e JAVAUUID_BASE_URL=http://host.docker.internal:8082 \
-e NANOID_BASE_URL=http://host.docker.internal:8083 \
-e RATE=5 \
-e TIME_UNIT=1 \
-e DURATION=300 \
-e PRE_ALLOCATED_VUS=5 \
-e MAX_VUS=5 \
grafana/k6:0.56.0 run --out json=/results/test_results.json /scripts/IDGenerationLoadTest.js
```
