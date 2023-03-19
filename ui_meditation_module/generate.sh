fvm flutter pub run pigeon \
  --input pigeons/book.dart \
  --dart_out lib/pigeon.dart \
  --experimental_kotlin_out .android/app/src/main/java/com/ui/meditation/module/ui_meditation_module/host/Pigeon.kt \
  --experimental_kotlin_package "dev.flutter.pigeon" \
  --java_out .android/app/src/main/java/com/ui/meditation/module/ui_meditation_module/host/Pigeon.java \
  --java_package "dev.flutter.pigeon"
  