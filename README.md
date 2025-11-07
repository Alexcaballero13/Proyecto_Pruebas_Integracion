# Proyecto Final - Pruebas de Integración y Sistema

Este proyecto corresponde al trabajo práctico sobre las **pruebas de integración y de sistema**, como parte final del curso **Testing y Validación de Software**.
El propósito es aplicar las técnicas vistas en el **Taller de Pruebas de Integración** para construir, ejecutar y documentar pruebas automatizadas que validen la interacción entre componentes y la estabilidad del sistema bajo escenarios reales.

---

## 🎯 Objetivos

- Aplicar principios de **pruebas de integración** sobre arquitecturas multicapa y/o microservicios.
- Diseñar y ejecutar **pruebas de sistema** a través de la capa REST o interfaz principal del software.
- Usar herramientas como **JUnit 5, Spring Boot Test, Mockito y H2** para validar la comunicación entre componentes.
- Asegurar la cobertura de integración mediante **JaCoCo** u otra herramienta equivalente.
- Documentar el proceso completo en el **Wiki del repositorio**, siguiendo la metodología vista en el taller.

---

### Estructura propuesta (arquitectura limpia)

```bash
src/
 ├─ main/java/edu/unisabana/proyecto/
 │   ├─ domain/            # Reglas de negocio
 │   ├─ application/       # Casos de uso (servicios, lógica de aplicación)
 │   ├─ infrastructure/    # Adaptadores y persistencia
 │   └─ delivery/rest/     # Controladores y endpoints REST
 └─ test/java/edu/unisabana/proyecto/
     ├─ unit/              # Pruebas unitarias
     ├─ integration/       # Pruebas de integración (H2, Mockito)
     └─ system/            # Pruebas de sistema (MockMvc, API)
```

- Debe compilarse y ejecutarse con:

```bash
mvn clean verify
mvn jacoco:report
```

- Las pruebas deben ejecutarse **de manera automática** sin pasos adicionales.

---

> 💡 Nota sobre el lenguaje de implementación
>
> El lenguaje de referencia en este taller es **Java**, dado su fuerte integración con el ecosistema de **JUnit 4/5**, **Spring Boot Test**, **Mockito** y **H2 Database**.
> No obstante, los principios y prácticas descritos son **transferibles a otros lenguajes**, siempre que el entorno soporte:
>
> - **Ejecución automatizada de pruebas** (por ejemplo, `pytest`, `Jest`, `NUnit`).
> - **Mocks o fakes** para aislar dependencias externas.
> - **Bases de datos en memoria o simuladas** para pruebas de integración.
> - **Herramientas de cobertura** como JaCoCo, Coverage.py o Istanbul.
>
> Estructura sugerida (Java + Arquitectura Limpia)
>
> En Java, la estructura recomendada sigue el estándar de **proyectos Maven** y la filosofía de **Arquitectura Limpia**, donde cada capa se prueba en distintos niveles:
>
> | Capa | Tipo de prueba | Ejemplo de herramienta | Objetivo |
> |------|----------------|------------------------|-----------|
> | Dominio | Unitarias | JUnit | Validar reglas de negocio puras. |
> | Aplicación | Integración | Mockito, H2 | Verificar la colaboración entre servicios y repositorios. |
> | Delivery | Sistema / REST | MockMvc | Probar endpoints reales y respuestas HTTP. |
>
> Adaptación a otros lenguajes
>
> Aunque el taller se enfoca en Java, las estrategias de **testing modular y de integración** se pueden aplicar con éxito en otros entornos:
>
> | Lenguaje | Framework de pruebas | Framework de mocks | Base en memoria | Cobertura |
> |-----------|----------------------|--------------------|----------------|------------|
> | Python | `pytest`, `unittest` | `unittest.mock`, `pytest-mock` | SQLite / Fake DB | `coverage.py` |
> | JavaScript | `Jest`, `Mocha` | Incluido en Jest | Mongo Memory Server / SQLite | `Istanbul` |
> | C# | `xUnit`, `NUnit` | `Moq` | InMemoryDB (EF Core) | `Coverlet` |
>
> - El taller prioriza **Java con Maven y Spring Boot**, pero promueve la **adaptación tecnológica**.
> - Todo el proceso se documente en el **Wiki del repositorio**, siguiendo la estructura del taller.
>
> ⚠️ El cambio de lenguaje **no exime** la aplicación de los conceptos ni la presentación de evidencias del proceso TDD.
> La evaluación se basará en la **metodología aplicada**, no en el lenguaje, sin embargo debe ser claro en la documentación sobre como se deben ejecutar las pruebas.

---

## PARA ENTREGAR

### 1. Repositorio principal

- Código fuente del proyecto con todas las pruebas automatizadas.
- Archivo `.gitignore` (excluir `target/`, `logs/`, archivos de IDE, etc.).
- Archivo `integrantes.txt` o sección en el README con los nombres del equipo.
- Ejecución reproducible:

```bash
mvn clean verify
```

- URL pública del repositorio (GitHub o GitLab).

---

### 2. Wiki del proyecto (documentación obligatoria)

> El Wiki será el documento oficial de entrega.
> Debe reflejar todo el proceso de diseño, ejecución y resultados de las pruebas.

#### Estructura sugerida del Wiki

1. **Inicio**
   - Descripción del dominio y propósito del sistema.
   - Diagrama de arquitectura (capas o componentes integrados).
   - Integrantes del equipo.

2. **Pruebas de Integración**
   - Escenarios de validación entre capas (`service ↔ repository`).
   - Uso de **H2** o **Mockito** para aislar dependencias.
   - Ejemplo de configuración de `@SpringBootTest` o `@DataJpaTest`.
   - Capturas de resultados de ejecución y reportes JaCoCo.

3. **Pruebas de Sistema**
   - Pruebas **end-to-end** con `MockMvc` u otra herramienta HTTP.
   - Validación de respuestas, estados HTTP y mensajes JSON.
   - Ejemplo de prueba `shouldReturnValidWhenPostRequest()`.

4. **Cobertura y Resultados**
   - Captura del reporte de **JaCoCo** (`target/site/jacoco/index.html`).
   - Mínimo **80% cobertura global** y evidencia de ejecución.
   - Identificación de las líneas no cubiertas y justificación.

5. **Registro de Defectos**
   - Archivo `defectos_integracion.md` con defectos encontrados.
   - Clasificación según tipo (unitaria, integración, sistema).
   - Estados: Abierto / En progreso / Resuelto.

6. **Conclusiones y Reflexión**
   - Qué defectos se detectaron antes del despliegue.
   - Qué desafíos se presentaron al probar múltiples capas.
   - Cómo las pruebas de integración mejoran la confianza del sistema.

---

## Métricas de calidad

| Métrica | Requisito mínimo |
|----------|------------------|
| **Cobertura global (JaCoCo o equivalente)** | ≥ 80% |
| **Cobertura de pruebas de integración** | ≥ 70% |
| **Número mínimo de pruebas de integración** | 3 |
| **Número mínimo de pruebas de sistema (MockMvc)** | 2 |
| **Errores no manejados (HTTP 500)** | 0 |
| **Buenas prácticas** | Código limpio, control de excepciones, mocks correctamente configurados. |

---

## Reflexión esperada en el Wiki

- ¿Qué diferencias encontraste entre las pruebas unitarias y de integración?
- ¿Qué capa presentó más desafíos al validar los datos?
- ¿Cómo se simularon los componentes externos (mocking o base de datos en memoria)?
- ¿Qué defectos se detectaron en la capa REST?
- ¿Qué aprendiste al ejecutar pruebas de sistema completas?

---

## Rúbrica de evaluación

| **Criterios de evaluación** | **Indicadores de cumplimiento** | **Excelente (5 pts)** | **Bueno (4 pts)** | **Necesita mejorar (3.5 pts)** | **Deficiente (2.5 pts)** | **No cumple (0 pts)** |
|------------------------------|---------------------------------|------------------------|--------------------|---------------------------------|---------------------------|------------------------|
| **Diseño de pruebas de integración** | Escenarios relevantes entre capas. | Casos completos, coherentes y reproducibles. | Casos bien definidos pero con fallos menores. | Escenarios incompletos. | Pruebas confusas o fallidas. | No hay pruebas de integración. |
| **Configuración del entorno (H2, Mockito)** | Configuración correcta y aislada. | Entorno estable, con base en memoria o mocks funcionales. | Configurado parcialmente. | Entorno inestable o acoplado. | No se puede ejecutar. | No configura entorno. |
| **Pruebas de sistema (MockMvc o similar)** | Cobertura de endpoints y validación de respuestas. | Casos claros con validación de estados HTTP y contenido. | Cobertura parcial o con respuestas ambiguas. | Escenarios incompletos. | Sin pruebas de sistema. | No aplica. |
| **Gestión de defectos** | Registro y seguimiento. | Archivo actualizado con análisis y estado de cada defecto. | Registro incompleto o sin estados. | Defectos listados sin análisis. | Registro mínimo o no actualizado. | No hay registro. |
| **Cobertura de código (JaCoCo)** | Porcentaje total y de integración. | ≥ 80% global y ≥ 70% en integración. | Entre 70% y 79%. | Entre 60% y 69%. | Menor a 60%. | No presenta. |
| **Documentación en Wiki** | Claridad, estructura y evidencias. | Completa y bien organizada. | Estructurada pero con faltantes menores. | Parcial o poco clara. | Incompleta o sin referencias. | No hay Wiki. |
| **Reflexión técnica y conclusiones** | Análisis y aprendizajes. | Reflexión profunda con ejemplos. | Reflexión general con evidencias parciales. | Superficial. | Mínima o sin conexión. | No presenta. |
| **Calidad general del proyecto** | Código, estructura y presentación. | Correcta integración entre código y documentación. | Buen nivel general con leves inconsistencias. | Parcialmente funcional. | Fallos críticos o sin coherencia. | No ejecuta o incompleto. |

| **Rango de puntaje** | **Desempeño** |
|----------------------|----------------|
| 45 – 50 | Excelente manejo de pruebas de integración y sistema. |
| 35 – 44 | Buen trabajo, ejecución completa pero con fallas menores. |
| 30 – 34 | Cumple con lo básico, faltan evidencias o profundidad. |
| < 30 | No cumple con los criterios mínimos del taller/proyecto. |

---

## Referencias

- Koskela, L. *Effective Unit and Integration Testing*.
- Martin, R. C. *Clean Architecture*.
- Spring Boot Docs: *Testing & MockMvc*.
- Fowler, M. *Continuous Integration*.
- ISO/IEC/IEEE 29119 – *Software Testing Standards*.

---

## Créditos y uso académico

**Autor:** César Augusto Vega Fernández
**Curso:** Testing y Validación de Software
**Programa:** Maestría en Ingeniería de Software – Universidad de La Sabana
**Año:** 2025

Este taller y su contenido fueron diseñados por el profesor **César Augusto Vega Fernández** como material académico para el curso *Testing y Validación de Software*, impartido en la **Maestría en Ingeniería de Software de la Universidad de La Sabana**.

Material de uso **exclusivamente académico**, orientado a fortalecer las competencias en **pruebas de integración, validación de API REST y control de defectos** dentro del ciclo DevSecOps.

---

### Licencia de uso

Este material se distribuye bajo la licencia [Creative Commons Atribución-NoComercial-CompartirIgual 4.0 Internacional (CC BY-NC-SA 4.0)](https://creativecommons.org/licenses/by-nc-sa/4.0/deed.es).

Puedes **usar, adaptar o compartir** este contenido con fines educativos, siempre que:

1. Se reconozca la autoría del profesor **César Augusto Vega Fernández**.
2. No se utilice con fines comerciales.
3. Las obras derivadas se distribuyan bajo la misma licencia.

---

© Universidad de La Sabana – Facultad de Ingeniería
Maestría en Ingeniería de Software – 2025
