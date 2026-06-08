# Reporte de resultados de ejecución

**Proyecto:** TYVS Proyecto Pruebas de Integración  
**Fecha:** 2026-06-08  
**Repositorio:** https://github.com/Alexcaballero13/Proyecto_Pruebas_Integracion.git

---

## 1. Resumen ejecutivo

| Indicador | Resultado |
|-----------|-----------|
| Comando de ejecución | `.\verify.cmd` (equivale a `mvn clean verify`) |
| Resultado build | **BUILD SUCCESS** |
| Pruebas unitarias + integración (Surefire) | 0 fallos |
| Pruebas de sistema (Failsafe, `*IT.java`) | 0 fallos |
| Cobertura JaCoCo global | **91%** (mínimo requerido: 80%) |
| Pipeline CI/CD (GitHub Actions) | **Success** |

---

## 2. Script de pruebas automatizadas

### Comando

```powershell
.\verify.cmd
```

### Estructura de pruebas

| Tipo | Ubicación | Herramienta | Cantidad |
|------|-----------|-------------|----------|
| Unitarias / Mockito | `src/test/.../unit/` | JUnit 4 + Mockito | 3 tests |
| Integración H2 | `src/test/.../integration/` | JUnit 4 + H2 | 4 tests |
| Sistema HTTP | `src/test/.../system/` | Spring Boot Test + TestRestTemplate | 3 tests |

### Artefactos de ejecución

| Reporte | Ruta local |
|---------|------------|
| Surefire | `target/surefire-reports/` |
| Failsafe | `target/failsafe-reports/` |

---

## 3. Pipeline CI/CD

- **Archivo:** `.github/workflows/ci.yml`
- **Trigger:** `push` y `pull_request` a `master` / `main`
- **Jobs:**
  1. `test-and-coverage` — ejecuta `mvn clean verify`, publica JaCoCo y reportes de prueba
  2. `merge-gate` — valida en PR que el job anterior haya pasado

### Evidencia

Ver carpeta `evidencias/02-pipeline/` y artifacts en GitHub Actions:
- `jacoco-coverage-report`
- `test-execution-report`

---

## 4. Métricas de cobertura (JaCoCo)

| Paquete | Cobertura instrucciones |
|---------|------------------------|
| `domain.model` | 100% |
| `delivery.rest` | 100% |
| `application.usecase` | 93% |
| `infrastructure.persistence` | 86% |
| **Total** | **91%** |

**Reporte HTML:** `target/site/jacoco/index.html`  
**Evidencia gráfica:** `evidencias/03-jacoco/`

---

## 5. Restricción de integración

El pipeline ejecuta pruebas automáticamente en cada push/PR. Si `mvn verify` falla, el workflow termina en **Failure**.

Para bloquear merges en GitHub cuando fallan los checks:

1. **Settings** → **Branches** → **Add branch protection rule**
2. Rama: `master`
3. Activar: **Require status checks to pass before merging**
4. Seleccionar: `test-and-coverage`

**Evidencia:** `evidencias/04-merge-protection/`

---

## 6. Conclusión

El proyecto cumple los requisitos técnicos del entregable: pruebas automatizadas ejecutables, pipeline CI/CD funcional con reportes publicados, y cobertura superior al umbral del 80%. La restricción formal de merge se completa al activar branch protection en GitHub (ver sección 5).
