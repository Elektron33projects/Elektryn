ELEKTRYN - szkielet buildu dla Minecrafta 26.x

1. Skopiuj zawartosc folderu "mc26" do glownego katalogu repozytorium (obok src, build.gradle).
2. Skopiuj swoj kod: src/main/java -> mc26/src/main/java
                     src/main/resources -> mc26/src/main/resources
   (fabric.mod.json i plik mixin tez; w fabric.mod.json ustaw "minecraft": "~26.1" i "java": ">=25")
3. Zastap .github/workflows/build.yml plikiem z tego zipa (dodaje job build-26).
4. Commit -> Actions -> artefakt elektryn-26.1.2.

UWAGA: to tylko szkielet. Nic nie zostalo zbudowane ani uruchomione.
Kod moda trzeba poprawic pod 26.x - bledy z logu wklej do Claude.
Sprawdz aktualne wersje Loom / Fabric Loader / Gradle na Fabric Develop.
Wersje 26.2 i 26.3 nie zostaly potwierdzone, dlatego ich nie ma.
