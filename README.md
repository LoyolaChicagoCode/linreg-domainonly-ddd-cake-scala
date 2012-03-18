Deliberately overengineered to illustrate domain-driven design and 
dependency injection using the Cake idiom.

Some key insights:

- Because stateless components are conceptually singletons, a concrete
  non-configurable component can define an implementation instance as
  singleton Scala object. Example: PointFactoryComponent and
  DefaultPointFactoryComponent.
  
- By contrast, stateful components should define a factory method so
  as to allow test clients to create fresh instances of the component
  implementation as needed. In addition, they should lazily and
  extensibly provide an instance. Example: PointRepositoryComponent
  and DefaultPointRepositoryComponent.
  
Based heavily on [this example](http://www.cakesolutions.net/teamblogs/2011/12/19/cake-pattern-in-depth/).
