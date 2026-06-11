package it.rjcsoft.dungeonbattle.nemici;

import it.rjcsoft.dungeonbattle.personaggi.Nemico;

public class Scheletro extends Nemico {
    private static final int MAX_VITA = 50;
    private static final int ATTACCO_BASE = 10;

    public Scheletro(String nome) {
        super("SCHELETRO", MAX_VITA, ATTACCO_BASE);
    }

    @Override
    public void sprite() {
        System.out.println("         .AMMMMMMMMMMA.         ");
        System.out.println("       .AV. :::.:.:.::MA.       ");
        System.out.println("      A\' :..        : .:`A       ");
        System.out.println("     A\'..               . `A.     ");
        System.out.println("    A\' :.    :::::::::  : :`A    ");
        System.out.println("    M  .    :::.:.:.:::  . .M    ");
        System.out.println("    M  :    ::.:.....::.:   .M    ");
        System.out.println("    V : :.::.:........:.:  :V    ");
        System.out.println("   A  A:    ..:...:...:.    A A   ");
        System.out.println("  .V  MA:.....:M.::.::. .:AM.M   ");
        System.out.println(" A\'  .VMMMMMMMMM:.:AMMMMMMMV: A  ");
        System.out.println(":M .  .`VMMMMMMV.:A `VMMMMV .:M: ");
        System.out.println(" V.:.  ..`VMMMV.:AM..`VMV\' .: V  ");
        System.out.println("  V.  .:. .....:AMMA. . .:. .V   ");
        System.out.println("   VMM...: ...:.MMMM.: .: MMV    ");
        System.out.println("       `VM: . ..M.:M..:::M\'      ");
        System.out.println("         `M::. .:.... .::M       ");
        System.out.println("          M:.  :. .... ..M       ");
        System.out.println("          V:  M:. M. :M .V       ");
        System.out.println("          `V.:M.. M. :M.V\'       ");

    }
}
