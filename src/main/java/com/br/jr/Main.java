package com.br.jr;

import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        // Substitua pelo seu token de autenticação
        String authToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiIsImtpZCI6IjI4YTMxOGY3LTAwMDAtYTFlYi03ZmExLTJjNzQzM2M2Y2NhNSJ9.eyJpc3MiOiJzdXBlcmNlbGwiLCJhdWQiOiJzdXBlcmNlbGw6Z2FtZWFwaSIsImp0aSI6IjM4YzU2ZGI3LWM5MDUtNDQ4ZC1hNzE4LWNlY2Y4YTA4ZGE0MiIsImlhdCI6MTczMjEwNDE1MCwic3ViIjoiZGV2ZWxvcGVyLzFmZTE0MjA5LTNjOWMtMjNmMi05ZmMxLWFhNDZlZTU5NzM3MCIsInNjb3BlcyI6WyJjbGFzaCJdLCJsaW1pdHMiOlt7InRpZXIiOiJkZXZlbG9wZXIvc2lsdmVyIiwidHlwZSI6InRocm90dGxpbmcifSx7ImNpZHJzIjpbIjE3Ny4xNzcuNjMuMTQ5Il0sInR5cGUiOiJjbGllbnQifV19.wyKE3tmSWGJhljBGa0FIh_eX6NIYGHnyndC7TdikvEsYCFtxr8cYggf-3ihLZlG11lca2yAtaXoRQjRZTjzBsA";

        // Instância única da API
        ClashAPI clashAPI = new ClashAPI(authToken);

        // Buscar dados do jogador
        String playerTag = "R2GL08U2";
        String playerData = clashAPI.getPlayerData(playerTag);

        if (playerData != null) {
            Gson gson = new Gson();
            InfoPlayer playerInfo = gson.fromJson(playerData, InfoPlayer.class);

            System.out.println("=== Dados do Jogador ===");
            System.out.println("tag: " + playerInfo.getTag());
            System.out.println("name: " + playerInfo.getName());
            System.out.println("townHallLevel: " + playerInfo.getTownHallLevel());
            System.out.println("townHallWeaponLevel: " + playerInfo.getTownHallWeaponLevel());
            System.out.println("expLevel: " + playerInfo.getExpLevel());
            System.out.println("trophies: " + playerInfo.getTrophies());
            System.out.println("bestTrophies: " + playerInfo.getBestTrophies());
            System.out.println("warStars: " + playerInfo.getWarStars());
            System.out.println("attackWins: " + playerInfo.getAttackWins());
            System.out.println("defenseWins: " + playerInfo.getDefenseWins());
            System.out.println("builderHallLevel: " + playerInfo.getBuilderHallLevel());
            System.out.println("builderBaseTrophies: " + playerInfo.getBestTrophies());
            System.out.println("bestBuilderBaseTrophies: " + playerInfo.getBestBuilderBaseTrophies());

        } else {
            System.out.println("Erro ao obter dados do jogador.");
        }

        // Buscar dados do clã
        String clanTag = "2YGPQYQP";
        String clanData = clashAPI.getClanData(clanTag);

        if (clanData != null) {
            Gson gson = new Gson();
            InfoClan clanInfo = gson.fromJson(clanData, InfoClan.class);

            System.out.println("=== Dados do Clã ===");
            System.out.println("tag: " + clanInfo.getTag());
            System.out.println("name: " + clanInfo.getName());
            System.out.println("type: " + clanInfo.getType());
            System.out.println("clanLevel: " + clanInfo.getClanLevel());
            System.out.println("clanPoints: " + clanInfo.getClanPoints());
            System.out.println("clanCapitalPoints: " + clanInfo.getClanCapitalPoints());
            System.out.println("warWins: " + clanInfo.getWarWins());
            System.out.println("warTies: " + clanInfo.getWarTies());
            System.out.println("warLosses: " + clanInfo.getWarLosses());


        } else {
            System.out.println("Erro ao obter dados do clã.");
        }
    }
}
