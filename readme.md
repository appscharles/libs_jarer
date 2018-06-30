# BUILD
For test project in Intelij IDEA, add to your gradle project configuration:
```
sourceSets.main.output.resourcesDir = 'out/production/classes'

task copyResourceForTest(type: Copy) {
    test.mustRunAfter copyResourceForTest
    from('out/production/classes')
    into('build/classes/java/main')
    exclude('*.class')
}

test.dependsOn copyResourceForTest
```