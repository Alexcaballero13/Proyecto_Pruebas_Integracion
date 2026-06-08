# Reporte de Resultados de Ejecución

## Comandos

```bash
mvn clean verify
mvn jacoco:report
```

## Artefactos generados

| Artefacto | Ubicación |
|-----------|-----------|
| Reporte JaCoCo | `target/site/jacoco/index.html` |
| Surefire (unit + integration) | `target/surefire-reports/` |
| Failsafe (system) | `target/failsafe-reports/` |

## Pipeline CI/CD

El workflow `.github/workflows/ci.yml` ejecuta automáticamente las pruebas antes de permitir integración de código en pull requests.

## Restricción de integración

- Push/PR a `main` o `master` dispara el pipeline.
- Si `mvn verify` falla (pruebas o cobertura < 80%), el job falla y bloquea el merge (configurar branch protection en GitHub).
