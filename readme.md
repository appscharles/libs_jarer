# BUILD
For test project in Intelij IDEA, add to your gradle project configuration:
```
sourceSets {
    main {
        output.resourcesDir = 'out/production/classes'
    }
}
```