package chandu0101.scalajs.sri.mobile.examples.uiexplorer.components

import chandu0101.scalajs.sri.core.ElementFactory._
import chandu0101.scalajs.sri.core.{ReactComponent, RefType}
import chandu0101.scalajs.sri.mobile.components._
import chandu0101.scalajs.sri.mobile.examples.uiexplorer.{UIExample, UIExplorerBlock, UIExplorerPage}
import chandu0101.scalajs.sri.mobile.styles.NativeStyleSheet

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{literal => json}
import scala.scalajs.js.UndefOr
import scala.scalajs.js.annotation.ScalaJSDefined


object SegmentedControlExample extends UIExample {

  object BasicSegmentedControlExample {

    @ScalaJSDefined
    class Component extends ReactComponent[Unit, Unit] {
      def render() = View()(
        SegmentedControlIOS(values = Seq("One", "Two"))
      )
    }

    val factory = getComponentFactory(new Component)

    def apply(key: UndefOr[String] = js.undefined, ref: RefType = null) = createElementNoProps(factory, key = key, ref = ref)
  }

  object PreSelectedSegmentedControlExample {

    @ScalaJSDefined
    class Component extends ReactComponent[Unit, Unit] {
      def render() = View()(
        SegmentedControlIOS(values = Seq("One", "Two"), selectedIndex = 0)
      )
    }

    val factory = getComponentFactory(new Component)

    def apply(key: UndefOr[String] = js.undefined, ref: RefType = null) = createElementNoProps(factory, key = key, ref = ref)
  }

  object MomentarySegmentedControlExample {

    @ScalaJSDefined
    class Component extends ReactComponent[Unit, Unit] {
      def render() = View()(
        SegmentedControlIOS(values = Seq("One", "Two"), momentary = true)
      )
    }

    val factory = getComponentFactory(new Component)

    def apply(key: UndefOr[String] = js.undefined, ref: RefType = null) = createElementNoProps(factory, key = key, ref = ref)
  }

  object DisabledSegmentedControlExample {

    @ScalaJSDefined
    class Component extends ReactComponent[Unit, Unit] {
      def render() = View()(
        SegmentedControlIOS(values = Seq("One", "Two"), enabled = false, selectedIndex = 0)
      )
    }

    val factory = getComponentFactory(new Component)

    def apply(key: UndefOr[String] = js.undefined, ref: RefType = null) = createElementNoProps(factory, key = key, ref = ref)
  }

  object ColorSegmentedControlExample {

    @ScalaJSDefined
    class Component extends ReactComponent[Unit, Unit] {
      def render() = View()(
        SegmentedControlIOS(values = Seq("One", "Two"), selectedIndex = 0, tintColor = "#ff0000")
      )
    }

    val factory = getComponentFactory(new Component)

    def apply(key: UndefOr[String] = js.undefined, ref: RefType = null) = createElementNoProps(factory, key = key, ref = ref)
  }

  object EventSegmentedControlExample {

    case class State(values: Seq[String] = Seq("One", "Two", "Three", "Four"), value: String = "One", index: Int = 0)

    @ScalaJSDefined
    class Component extends ReactComponent[Unit, State] {

      initialState(State())

      def render() = View()(
        Text(style = styles.text)(s"Value : ${state.value}"),
        Text(style = styles.text)(s"Index : ${state.values.indexOf(state.value)}"),
        SegmentedControlIOS(values = state.values, selectedIndex = state.index,
          tintColor = "#cf00a2",
          onChange = onChange _,
          onValueChange = onValueChange _
        )
      )

      def onChange(e: js.Dynamic) = {
        setState(state.copy(index = e.nativeEvent.selectedSegmentIndex.toString.toInt))
      }

      def onValueChange(value: String) = setState(state.copy(value = value))
    }

    val factory = getComponentFactory(new Component)

    def apply(key: UndefOr[String] = js.undefined, ref: RefType = null) = createElementNoProps(factory, key = key, ref = ref)

  }


  @ScalaJSDefined
  class Component extends ReactComponent[Unit, Unit] {
    def render() = UIExplorerPage(
      View()(
        UIExplorerBlock("Segmented controls can have values")(
          BasicSegmentedControlExample()
        ),
        UIExplorerBlock("Segmented controls can have a pre-selected value")(
          PreSelectedSegmentedControlExample()
        ),
        UIExplorerBlock("Segmented controls can be momentary")(
          MomentarySegmentedControlExample()
        ),
        UIExplorerBlock("Segmented controls can be disabled")(
          DisabledSegmentedControlExample()
        ),
        UIExplorerBlock("Custom colors can be provided")(
          ColorSegmentedControlExample()
        ),
        UIExplorerBlock("Change events can be detected")(
          EventSegmentedControlExample()
        )
      )
    )
  }

  val factory = getComponentFactory(new Component)

  val component = createElementNoProps(factory)


  object styles extends NativeStyleSheet {

    val text = style(fontSize := 14,
      textAlign.center,
      fontWeight._500,
      margin := 10)


  }


  override def title: String = "SegmentedControlIOS"

  override def description: String = "Native segmented control"
}
