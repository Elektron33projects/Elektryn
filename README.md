# Elektryn — source project

This folder is a GitHub-ready Gradle/Fabric project reconstructed from the uploaded `Elektryn 26 Low RAM` JAR.

## Important compatibility note

The inspected JAR manifest says it was built with **Minecraft 1.21.11**, Fabric Loader 0.16.10, intermediary mappings, and Java 21. Editing `fabric.mod.json` to list Minecraft 26.1–26.3 does **not** port the compiled code to those game versions. This source project therefore declares Minecraft 1.21.11 as its build target. Port and test the code against each newer Minecraft version before publishing separate compatible builds.

The Java files were reconstructed from the compiled classes, not recovered from an original source repository. The Gradle dependencies and some mapped method names may need adjustment to match the exact Yarn mapping build available for the target version. A successful Gradle build and in-game test are still required.

## What the current preset does

- Sets the non-player entity culling distance to 24 blocks.
- Disables entity shadows.
- Selects the second enum value for particle settings when available (commonly a reduced-particle setting; verify the enum ordering for the target version).
- Sets biome blend radius to 0.
- Sets mipmap levels to 0.
- Sets entity distance scaling to 0.75.
- Does not intentionally lower the chunk render distance.
- Does not guarantee lower total RAM usage or higher FPS.

Settings are applied once, on first launch, using `config/elektryn-applied.flag` as a marker. Delete that marker if you want the preset to be applied again. The preset writes the changed options to the normal Minecraft options file.

## Build

Requirements: JDK 21 and a compatible Gradle installation. The Gradle wrapper is not included in this generated folder.

```bash
gradle build
```

The built JAR will be in `build/libs/`.

## GitHub upload

1. Extract this folder.
2. Create a new repository on GitHub.
3. Upload the contents of this folder (the `src`, `build.gradle`, `settings.gradle`, `gradle.properties`, `README.md`, `LICENSE`, and `.gitignore` files), not just the ZIP file.
4. Do not label a build as compatible with Minecraft 26.x until it has been ported and tested on those versions.

## License

MIT; see `LICENSE`.
