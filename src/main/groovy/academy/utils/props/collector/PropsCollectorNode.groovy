package academy.utils.props.collector

class PropsCollectorNode {

    String collected

    PropsCollectorNode next

    def propertyMissing(String name) {
        next = new PropsCollectorNode(collected: name)
    }

}
