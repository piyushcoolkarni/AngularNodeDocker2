package computerdatabase

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class AngularNodeEmsDockerSimulation extends Simulation {

  val httpConf = http
    .baseURL("http://localhost:3033") // Here is the root for all relative URLs
    .acceptHeader("application/json,text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // Here are the common headers
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

  val headers_10 = Map("Content-Type" -> """application/x-www-form-urlencoded""") // Note the headers specific to a given request

  val scn = scenario("Ems Application Testing") // A scenario is a chain of requests and pauses
    

.exec(
    http("get request")
      .get("/api/users"))
.pause(1)

  setUp(scn.inject(atOnceUsers(200)).protocols(httpConf))
} 

