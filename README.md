# spring-redis
##spring boots for simple *redis* test

This demo required redis sentinel enable running on minikube.
install redis sentinel via helm
>helm install my-redis bitnami/redis --set "sentinel.enabled=true"

1. Compile and package
>mvn clean package
2. Build docker images
>docker build -t xxx/spring-redis:0.0.1 .
3. Push to docker repo
>docker push xxxs/pring-redis:0.0.1 
4. Deploy application to minikube
>kubectl create -f spring-redis-deployment.yaml
> 
>kubectl create -f spring-redis-cm.yaml 
> 
>kubectl create -f spring-redis-svc.yaml

5. Test your api
>kubectl port-forward svc/spring-redis 7080:8080
> 
> curl -i localhost:7080/hello