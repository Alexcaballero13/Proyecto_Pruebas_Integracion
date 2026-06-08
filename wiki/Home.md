# Wiki - Proyecto Pruebas de Integración

## 1. Inicio

Sistema de registro de votantes con arquitectura limpia (domain, application, infrastructure, delivery).

**Ejecución:** `mvn clean verify`

## 2. Pruebas de integración

- `RegistryIntegrationTest` — H2 en memoria, 4 escenarios (VALID, DUPLICATED, UNDERAGE, DEAD).

## 3. Pruebas de sistema

- `RegistryControllerIT` — TestRestTemplate, validación HTTP 200/400.

## 4. Cobertura JaCoCo

Reporte: `target/site/jacoco/index.html` — mínimo 80% global.

## 5. CI/CD

Pipeline en `.github/workflows/ci.yml` ejecuta `mvn verify` en cada push/PR. Los merges requieren pipeline exitoso.

## 6. Defectos

Ver [defectos_integracion.md](../defectos_integracion.md).

## 7. Conclusiones

Las pruebas de integración con H2 validaron persistencia real; Mockito aceleró escenarios de error; las pruebas HTTP detectaron falta de manejo de excepciones en la capa REST.
