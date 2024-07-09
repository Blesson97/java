The given Java code is written in Java 8. 

To upgrade the code to be compatible with Java 17 and incorporate new language features, standards, and best practices, we can make the following modifications:

1. Update the package declaration:
```java
package com.example.department.controller;
```

2. Use the `var` keyword for local variable type inference:
```java
var department = repo.findByDid(did);
```

3. Use `Optional` for better null handling and return type safety:
```java
public ResponseEntity<Optional<Department>> getbyid(@PathVariable int did) {
    Optional<Department> department = repo.findByDid(did);
    if (department.isEmpty()) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.of(department);
}
```

4. Update the controller's annotations:
   - Use `@RestController` instead of `@Controller` and `@ResponseBody`.
   - Use `@RequestParam` instead of `@PathVariable` in the `getbyid` method.

```java
@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentRepo repo;

    @PostMapping("/submit")
    public ResponseEntity<Department> submit(@RequestBody Department department) {
        return ResponseEntity.ok(repo.save(department));
    }

    @GetMapping("/dept")
    public ResponseEntity<List<Department>> getAllDepartments() {
        return ResponseEntity.ok(repo.findAll());
    }

    @GetMapping("/{did}")
    public ResponseEntity<Optional<Department>> getById(@RequestParam("did") int departmentId) {
        Optional<Department> department = repo.findByDid(departmentId);
        if (department.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.of(department);
    }
}
```

With these modifications, the code is upgraded to be compatible with Java 17 and incorporates new language features, standards, and best practices.