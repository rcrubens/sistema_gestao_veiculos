public class Teste {

    private static Passeio passeio = new Passeio();
    private static Carga carga = new Carga();

    private static Passeio vetPasseio[] = new Passeio[2];
    private static Carga vetCarga[] = new Carga[2];

    private static Leitura leitura = new Leitura();

    public static void main(String[] args) {

        boolean continua = true;
        int opcao = 0;

        while (continua) {

            System.out.println("\n\t\t\tMENU INICIAL:");
            System.out.println("\t(1) Cadastrar veiculo de PASSEIO");
            System.out.println("\t(2) Cadastrar veiculo de CARGA");
            System.out.println("\t(3) Imprimir todos os veiculos de PASSEIO");
            System.out.println("\t(4) Imprimir todos os veiculos de CARGA");
            System.out.println("\t(5) Imprimir veiculo de PASSEIO pela placa");
            System.out.println("\t(6) Imprimir veiculo de CARGA pela placa");
            System.out.println("\t(7) Sair do sistema");

            try {
                opcao = Integer.parseInt(leitura.entDados("\n\tEscolha uma opcao"));
            } catch (NumberFormatException nfe) {
                System.out.println("Gentileza informar um numero inteiro - pressione <ENTER>");
                leitura.entDados("");

                continue;
            }

            switch (opcao) {
                case 1:
                    for (int i = achaVagoPasseio(); i < vetPasseio.length; i++) {
                        if (i == -1) {
                            leitura.entDados("\nVetor de PASSEIO esta cheio! Pressione <ENTER>");
                            break;
                        }
                        passeio = new Passeio();
                        vetPasseio[i] = cadPasseio(passeio);

                        leitura.entDados("\nPASSEIO armazenado na posicao " + i + " do vetor - pressione <ENTER>");

                        String respPass = leitura.entDados("Deseja cadastrar outro PASSEIO? <s/n>");

                        if (respPass.equalsIgnoreCase("n")) {
                            break;
                        }
                        if (achaVagoPasseio() == -1) {
                            leitura.entDados("\nVetor de PASSEIO esta cheio! - pressione <ENTER>");
                            break;
                        }
                    }
                    break;

                case 2:
                    for (int i = achaVagoCarga(); i < vetCarga.length; i++) {
                        if (i == -1) {
                            leitura.entDados("\nVetor de CARGA esta cheio! Pressione <ENTER>");
                            break;
                        }
                        carga = new Carga();
                        vetCarga[i] = cadCarga(carga);

                        leitura.entDados("\nCarga armazenado na posicao " + i + " do vetor - pressione <ENTER>");

                        String respCarg = leitura.entDados("Deseja cadastrar outro Carga? <s/n>");

                        if (respCarg.equalsIgnoreCase("n")) {
                            break;
                        }
                        if (achaVagoCarga() == -1) {
                            leitura.entDados("\nVetor de CARGA esta cheio! - pressione <ENTER>");
                            break;
                        }
                    }
                    break;

                case 3:

                    System.out.println("\nPASSEIO - impressao de todos os veiculos");
                    System.out.println("==================================================");
                    for (int i = 0; i < vetPasseio.length; i++) {
                        if (vetPasseio[i] != null) {
                            impPasseio(vetPasseio[i], i);
                        } else {
                            leitura.entDados("\nSem mais veiculos de passeio para imprimir - pressione <ENTER>");
                        }
                    }
                    System.out.println("==================================================");

                    break;

                case 4:

                    System.out.println("\nCARGA - impressao de todos os veiculos");
                    System.out.println("==================================================");
                    for (int i = 0; i < vetCarga.length; i++) {
                        if (vetCarga[i] != null) {
                            impCarga(vetCarga[i], i);
                        } else {
                            leitura.entDados("\nSem mais veiculos de carga para imprimir - pressione <ENTER>");
                        }
                    }
                    System.out.println("==================================================");

                    break;

                case 5:

                    System.out.println("\nConsulta veiculo de PASSEIO pela PLACA");
                    System.out.println("==================================================");

                    passeio = new Passeio();

                    boolean existPlacaPass = false;

                    String placaPass = leitura.entDados("\nInforme a placa a ser pesquisada: ");

                    passeio.setPlaca(placaPass);

                    for (int i = 0; i < vetPasseio.length; i++) {
                        if (vetPasseio[i].getPlaca().equalsIgnoreCase(passeio.getPlaca())) {
                            impPasseio(vetPasseio[i], i);
                            existPlacaPass = true;

                        }

                    }
                    if (!existPlacaPass) {
                        leitura.entDados(
                                "\n\n\t\t\t====== NAO existe veiculo de PASSEIO com a placa informada - pressione <ENTER>");
                    }

                    break;

                case 6:

                    System.out.println("\nConsulta veiculo de CARGA pela PLACA");
                    System.out.println("==================================================");

                    carga = new Carga();

                    boolean existPlacaCarg = false;

                    String placaCarg = leitura.entDados("\nInforme a placa a ser pesquisada: ");

                    carga.setPlaca(placaCarg);

                    for (int i = 0; i < vetCarga.length; i++) {
                        if (vetCarga[i].getPlaca().equalsIgnoreCase(carga.getPlaca())) {
                            impCarga(vetCarga[i], i);
                            existPlacaCarg = true;

                        }

                    }
                    if (!existPlacaCarg) {
                        leitura.entDados(
                                "\n\n\t\t\t====== NAO existe veiculo de CARGA com a placa informada - pressione <ENTER>");
                    }
                    break;

                case 7:

                    continua = false;
                    break;

                default:
                    leitura.entDados("\nO valor deve ser >= 1 e <= 7 - pressione <ENTER>");
                    break;

            }
        }
    }

    public static int achaVagoPasseio() {
        for (int i = 0; i < vetPasseio.length; i++) {
            if (vetPasseio[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public static int achaVagoCarga() {
        for (int i = 0; i < vetCarga.length; i++) {
            if (vetCarga[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public static Passeio cadPasseio(Passeio passeio) {
        System.out.println("\n\n==================================================");
        System.out.println("Cadastro de veiculos de PASSEIO");
        System.out.println("==================================================");
        passeio.setQtdPassageiros(Integer.parseInt(leitura.entDados("Qtd de Passageiros: ")));
        passeio.setPlaca(leitura.entDados("\nPlaca: "));
        passeio.setMarca(leitura.entDados("Marca: "));
        passeio.setModelo(leitura.entDados("Modelo: "));
        passeio.setCor(leitura.entDados("Cor: "));
        passeio.setQtdRodas(Integer.parseInt(leitura.entDados("Qtd rodas: ")));
        passeio.setVelocMax(Integer.parseInt(leitura.entDados("Velocidade maxima: ")));
        passeio.getMotor().setQtdPist(Integer.parseInt(leitura.entDados("Qtd de pistoes do motor: ")));
        passeio.getMotor().setPotencia(Integer.parseInt(leitura.entDados("Potencia do motor: ")));

        return passeio;
    }

    public static Carga cadCarga(Carga carga) {
        System.out.println("\n\n==================================================");
        System.out.println("Cadastro de veiculos de CARGA");
        System.out.println("==================================================");
        carga.setPlaca(leitura.entDados("\nPlaca: "));
        carga.setMarca(leitura.entDados("Marca: "));
        carga.setModelo(leitura.entDados("Modelo: "));
        carga.setCor(leitura.entDados("Cor: "));
        carga.setQtdRodas(Integer.parseInt(leitura.entDados("Qtd rodas: ")));
        carga.setVelocMax(Integer.parseInt(leitura.entDados("Velocidade maxima: ")));
        carga.getMotor().setQtdPist(Integer.parseInt(leitura.entDados("Qtd de pistoes do motor: ")));
        carga.getMotor().setPotencia(Integer.parseInt(leitura.entDados("Potencia do motor: ")));
        carga.setCargaMax(Integer.parseInt(leitura.entDados("Carga maxima: ")));
        carga.setTara(Integer.parseInt(leitura.entDados("Tara: ")));

        return carga;
    }

    public static void impPasseio(Passeio passeio, int i) {

        System.out.println("\nPasseio armazenado no endereco: " + i + " do vetor vetPasseio");
        System.out.println("Placa: " + passeio.getPlaca());
        System.out.println("Marca: " + passeio.getMarca());
        System.out.println("Modelo: " + passeio.getModelo());
        System.out.println("Cor: " + passeio.getCor());
        System.out.println("Velocidade Maxima: " + passeio.calcVel());
        System.out.println("Quantidade de rodas: " + passeio.getQtdRodas());
        System.out.println("qtdPist: " + passeio.getMotor().getQtdPist());
        System.out.println("potencia: " + passeio.getMotor().getPotencia());
        System.out.println("Qtd. passageiros: " + passeio.getQtdPassageiros());
        System.out.println("Qtd total de letras: " + passeio.calcular());

    }    

    public static void impCarga(Carga carga, int i) {

        System.out.println("\nCarga armazenado no endereco: " + i + " do vetor vetCarga");
        System.out.println("Placa: " + carga.getPlaca());
        System.out.println("Marca: " + carga.getMarca());
        System.out.println("Modelo: " + carga.getModelo());
        System.out.println("Cor: " + carga.getCor());
        System.out.println("Velocidade Maxima: " + carga.calcVel());
        System.out.println("Quantidade de rodas: " + carga.getQtdRodas());
        System.out.println("Qtd. Pistoes Motor: " + carga.getMotor().getQtdPist());
        System.out.println("Potencia do Motor: " + carga.getMotor().getPotencia());
        System.out.println("Carga maxima: " + carga.getCargaMax());
        System.out.println("Tara: " + carga.getTara());
        System.out.println("Qtd total atributos numericos: " + carga.calcular());

    }   
}
