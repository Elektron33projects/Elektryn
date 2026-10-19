package pl.elektryn;

/** Default values for Elektryn's client-side tweaks. */
public final class ElektrynConfig {
    private ElektrynConfig() {}

    /** Maximum distance at which non-player entities are rendered, in blocks. */
    public static double entityCullDistance = 24.0;
    public static boolean disableEntityShadows = true;
    public static boolean reduceParticles = true;
    public static boolean noBiomeBlend = true;
    public static boolean noMipmaps = true;
    public static boolean uncapFps = false;
}
