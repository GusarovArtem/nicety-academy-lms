package academy.util.property

class PropsCollectorNode {

    String collected

    PropsCollectorNode next

    def propertyMissing(String name) {
        next = new PropsCollectorNode(collected: name)
    }

}
