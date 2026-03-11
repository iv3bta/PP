package org.example;

import org.graalvm.polyglot.*;

public class Main {
    public static void main(String[] args) {
        // dam acces la I/O pt a citi de la tastatura din python
        Context context = Context.newBuilder().allowAllAccess(true).build();

        String pythonScript =
                "import math\n" +
                        "try:\n" +
                        "    n = int(input('Numarul de aruncari: '))\n" +
                        "    x = int(input('Maxim pajuri: '))\n" +
                        "    if 1 <= x <= n:\n" +
                        "        # calc probabilitate cumulata P(X <= x) pt o moneda corecta (p=0.5)\n" +
                        "        prob = sum(math.comb(n, i) * (0.5**n) for i in range(x + 1))\n" +
                        "        print(f'Probabilitatea de a obtine cel mult {x} pajuri din {n} aruncari este {prob:.4f}')\n" +
                        "    else:\n" +
                        "        print('eroare: x trebuie sa fie intre 1 si n')\n" +
                        "except ValueError:\n" +
                        "    print('te rog introdu numere intregi valide')\n";

        context.eval("python", pythonScript);

        context.close();
    }
}