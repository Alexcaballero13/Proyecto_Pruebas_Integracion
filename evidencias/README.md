# Evidencias técnicas — Proyecto integrador

Índice de evidencias para el entregable de la unidad **Gestión de defectos**.

## Mapa requisito → evidencia

| # | Requisito obligatorio | Estado | Evidencia en esta carpeta |
|---|------------------------|--------|---------------------------|
| 1 | Script de pruebas automatizadas | ✅ Cumplido | `01-pruebas/` |
| 2 | Pipeline CI/CD funcional | ✅ Cumplido | `02-pipeline/` |
| 3 | Métricas de cobertura de código | ✅ Cumplido | `03-jacoco/` |
| 4 | Reporte de resultados de ejecución | ✅ Cumplido | `../reporte_ejecucion.md` |
| 5 | Restricción de integración (merge bloqueado si fallan tests) | ⚠️ Parcial | `04-merge-protection/` |

**Resumen: 4 de 5 cumplidos al 100%. El punto 5 requiere activar Branch Protection en GitHub.**

---

## Contenido de cada subcarpeta

### `01-pruebas/`
Capturas o export de:
- Estructura de tests (`unit/`, `integration/`, `system/`)
- Salida de `.\verify.cmd` con `BUILD SUCCESS`
- Surefire/Failsafe reports (opcional)

**Archivos sugeridos:**
- `estructura-tests.png`
- `verify-cmd-success.png`
- `surefire-resultados.png`

### `02-pipeline/`
Capturas de GitHub Actions:
- Vista general **Success** del workflow
- Job `test-and-coverage` expandido
- Log del paso "Run tests with JaCoCo coverage" (final con BUILD SUCCESS)
- Artifacts generados (`jacoco-coverage-report`, `test-execution-report`)

**Archivos sugeridos:**
- `actions-success.png`
- `job-test-and-coverage.png`
- `log-build-success.png`
- `artifacts.png`

### `03-jacoco/`
Capturas del reporte JaCoCo:
- Tabla resumen con **Total ≥ 80%** (actual: 91%)
- Detalle por paquete (opcional)

**Archivos sugeridos:**
- `jacoco-total-91porciento.png`
- `jacoco-por-paquete.png`

### `04-merge-protection/`
Evidencia de que no se puede mergear si el pipeline falla:
- Configuración de **Branch protection rule** en Settings → Branches
- PR con checks ✅ (merge permitido)
- PR con checks ❌ (merge bloqueado) — opcional pero recomendado

**Archivos sugeridos:**
- `branch-protection-config.png`
- `pr-checks-passed.png`
- `pr-checks-failed.png` (si hiciste la prueba de fallo)

---

## Cómo generar las capturas que faltan

1. Ejecuta localmente: `.\verify.cmd` → captura pantalla al ver `BUILD SUCCESS`
2. Abre JaCoCo: `start target\site\jacoco\index.html` → captura la tabla Total
3. En GitHub → Actions → abre el run verde → captura cada sección
4. Settings → Branches → activa protección → captura la configuración

---

## Repositorio y equipo

- **Repositorio:** URL de tu fork/repo personal en GitHub
- **Integrantes:** ver `integrantes.txt` en la raíz del proyecto
