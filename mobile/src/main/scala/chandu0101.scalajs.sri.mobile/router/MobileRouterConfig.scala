package chandu0101.scalajs.sri.mobile.router

import chandu0101.scalajs.sri.core.ReactElement
import chandu0101.scalajs.sri.mobile.components.NavigatorM

import scala.scalajs.js


trait MobileRouterConfig {

  private var _routes: Map[Page, Route] = Map()

  @inline lazy val routes: Map[Page, Route] = _routes.+(initialRoute)

  def initialRoute: (StaticPage, StaticRoute)

  def staticRoute(page: StaticPage, route: StaticRoute) = {
    _routes += page -> route
  }

  def dynamicRoute[T](page: DynamicPage[T], route: DynamicRoute[T]) = {
    _routes += page -> route
  }

  def notFound: StaticRoute = initialRoute._2

  def renderScene(route: js.Dynamic,navigator : NavigatorM): ReactElement = {
    if (!js.isUndefined(route.data)) {
      route.getComponent(route.data).asInstanceOf[ReactElement]
    } else {
      route.component().asInstanceOf[ReactElement]
    }
  }
}
