import random
import time


print("🎮 Добро пожаловать в Битву Героев!\n")

characters = {
    1: {"name": "Рыцарь", "health": 100, "attack": (15, 25)},
    2: {"name": "Лучник", "health": 90, "attack": (10, 30)},
    3: {"name": "Маг", "health": 80, "attack": (20, 35)},
}

strategies = {
    1: "Атаковать прямо",
    2: "Защищаться",
    3: "Использовать особый приём"
}

# Игрок выбирает персонажа
print("Выбери своего героя:")
for num, info in characters.items():
    print(f"{num}. {info['name']} (здоровье: {info['health']})")

choice = int(input("\n➡️ Введи номер героя: "))
player = characters.get(choice, characters[1])
print(f"\nТы выбрал {player['name']}! Да начнётся битва!\n")

# Противник выбирается случайно
enemy = random.choice(list(characters.values()))
while enemy == player:
    enemy = random.choice(list(characters.values()))

print(f"Твой противник — {enemy['name']}!\n")
time.sleep(1.5)

# Выбор стратегии
print("Выбери стратегию боя:")
for num, strat in strategies.items():
    print(f"{num}. {strat}")

strategy_choice = int(input("\n➡️ Введи номер стратегии: "))
strategy = strategies.get(strategy_choice, "Атаковать прямо")
print(f"\nТы выбрал стратегию: {strategy}\n")
time.sleep(1)

# Основной цикл боя
round_num = 1
while player["health"] > 0 and enemy["health"] > 0:
    print(f"\n⚡ Раунд {round_num}")
    time.sleep(1)

    # Атака игрока
    player_damage = random.randint(*player["attack"])
    enemy_damage = random.randint(*enemy["attack"])

    # Влияние стратегии
    if strategy_choice == 2:  # защита
        enemy_damage = int(enemy_damage * 0.7)
        print("🛡️ Ты выбрал защиту — получаешь меньше урона!")
    elif strategy_choice == 3:  # особый приём
        player_damage = int(player_damage * 1.4)
        print("🔥 Особый приём! Урон увеличен!")

    enemy["health"] -= player_damage
    player["health"] -= enemy_damage

    print(f"Ты нанёс {player_damage} урона. У противника осталось {max(enemy['health'],0)} HP.")
    print(f"Противник ударил тебя на {enemy_damage}. У тебя осталось {max(player['health'],0)} HP.")

    time.sleep(1.5)
    round_num += 1

# Определяем победителя
print("\n🎯 Финал боя!\n")
time.sleep(1)

if player["health"] > 0 and enemy["health"] <= 0:
    print(f"🏆 Победил {player['name']}! Слава герою!")
elif enemy["health"] > 0 and player["health"] <= 0:
    print(f"💀 Победил {enemy['name']}. Не расстраивайся, попробуй снова!")
else:
    print("🤝 Оба пали в бою. Ничья, но это было эпично!")
