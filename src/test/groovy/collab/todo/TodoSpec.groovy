package collab.todo

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Todo)
class TodoSpec extends Specification {

    void setup() {
      Todo.list()*.delete()
    }

    def cleanup() {
    }

    void testPersist() {
      new Todo(name: "1", createdDate:new Date(), priority: "", status:"").save()
      new Todo(name: "2", createdDate:new Date(), priority: "", status:"").save()
      new Todo(name: "3", createdDate:new Date(), priority: "", status:"").save()
      new Todo(name: "4", createdDate:new Date(), priority: "", status:"").save()
      new Todo(name: "5", createdDate:new Date(), priority: "", status:"").save()

      assert 5 == Todo.count()
      def actualTodo = Todo.findByName('1')
      assert actualTodo
      assert '1' == actualTodo.name
    }

    void testToString() {
      def todo = new Todo(name: "Pickup laundry")
      assertToString(todo, "Pickup laundry")
    }

    //void "test something"() {
      //  expect:"fix me"
        //    true == false
    //}
}
