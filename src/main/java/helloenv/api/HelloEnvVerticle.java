package helloenv.api;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.CorsHandler;



public class HelloEnvVerticle extends AbstractVerticle{
	
	
	
	
	
	
	
	/**
	 * Methode principale Vertx
	 */
	@Override
	public void start(final Future<Void> startFuture) throws Exception {

		final Router router = Router.router(vertx);
		router.route().handler(CorsHandler.create("*")
				.allowedMethod(io.vertx.core.http.HttpMethod.GET)
				.allowedHeader("Access-Control-Request-Method")
				.allowedHeader("Access-Control-Allow-Credentials")
				.allowedHeader("Access-Control-Allow-Origin")
				.allowedHeader("Access-Control-Allow-Headers")
				.allowedHeader("Content-Type"));
		
		router.get("/hello").handler(this::lancerShow);
		
	
		int portServer=Integer.parseInt(System.getenv("SRVPORT"));
			    vertx.createHttpServer().requestHandler(router) 
				.listen(portServer, res -> {
					if (res.succeeded()) {
						System.out.println("Serveur demarré sur le port "+portServer);
						startFuture.complete();
					} else {
						startFuture.fail(res.cause());
					}
				});
			    			    
			  
			
		
	}
	
	
	private void lancerShow(RoutingContext ctx) {
		
			ctx.response().putHeader("Content-Type", "application/json").end("{\"reponse\":\""+System.getenv("MSG")+"\"}");
		
		
	}
	
	
	
	
	
}
