# ProyectoFinalV-VG4

### Integrantes:
- Keler Modesto Calixro
- Angelou Villar Arias
- Francesco Abad
- Luis Sifuentes
- Diego D.
# PetClinic Automation Testing Project

## Propósito del Proyecto

El propósito de este proyecto es realizar pruebas automatizadas sobre el sistema **PetClinic** utilizando una combinación de herramientas de pruebas y análisis, como **JUnit**, **Selenium**, **SonarQube**, **JMeter**, **OWASP ZAP** y **Jenkins**. Este proyecto tiene como objetivo asegurar la calidad del código y verificar el correcto funcionamiento de las funcionalidades del sistema PetClinic a través de pruebas de seguridad, rendimiento, funcionalidad y análisis estático.

---
## Objetivos

El objetivo de este proyecto es implementar un pipeline de integración continua y entrega continua (CI/CD) que permita realizar las siguientes actividades:

- Realizar pruebas unitarias para verificar el funcionamiento correcto de las funcionalidades.
- Realizar pruebas funcionales para asegurar que las funcionalidades del sistema trabajen según lo esperado.
- Ejecutar pruebas de seguridad usando herramientas como **OWASP ZAP**.
- Ejecutar pruebas de rendimiento utilizando **JMeter**.
- Integrar todo el flujo de pruebas y análisis en un **pipeline de Jenkins**.
- Análisis estático del código con **SonarQube**.

---


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
