# ProyectoFinalV-VG4

### Integrantes:
- Keler Modesto Calixro
- Angelou Villar Arias
- Francesco Abad
- Luis Sifuentes
- Diego D.


### Modificaciones para mantenibilidad y consistencia basados en el análisis de Sonar

owner/Owner.java : Nested code

```java
	public Pet getPet(String name, boolean ignoreNew) {
        for (Pet pet : getPets()) {
            String compName = pet.getName();
            if (compName != null && compName.equalsIgnoreCase(name)) {
                if (!ignoreNew || !pet.isNew()) {
                    return pet;
                }
            }
        }
        return null;
    }
```

Solución : Merge

```java
	public Pet getPet(String name, boolean ignoreNew) {
        for (Pet pet : getPets()) {
            String compName = pet.getName();
            if (compName != null && compName.equalsIgnoreCase(name) && (!ignoreNew || !pet.isNew())) {
                return pet;
            }
        }
        return null;
    }
```

owner:PetController.java : Declaring a variable only to immediately return or throw it is considered a bad practice because it adds unnecessary complexity to the code

```java
	public Owner findOwner(@PathVariable("ownerId") int ownerId) {
        Optional<Owner> optionalOwner = this.owners.findById(ownerId);
        Owner owner = optionalOwner.orElseThrow(() -> new IllegalArgumentException(
                "Owner not found with id: " + ownerId + ". Please ensure the ID is correct "));
        return owner;
    }
```

Solución: Retornar inmedaitamente

```java
	public Owner findOwner(@PathVariable("ownerId") int ownerId) {
		Optional<Owner> optionalOwner = this.owners.findById(ownerId);
		return optionalOwner.orElseThrow(() -> new IllegalArgumentException(
				"Owner not found with id: " + ownerId + ". Please ensure the ID is correct "));
	}
```