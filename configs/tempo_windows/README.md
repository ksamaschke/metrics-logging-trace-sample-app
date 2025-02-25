# How to install on Windows

1. Download from https://github.com/grafana/tempo/releases > tempo_x.y.z_windows_amd64.tar.gz 
2. Extract to `C:\tempo` from the commandline: `tar -xcf tempo_x.y.z_windows_amd64.tar.gz -C C:\tempo`.
3. Copy the provided `config.yaml` file to said directory.

# How to start on Windows

1. Navigate to `C:\tempo` in Console / Terminal.
2. Start via `tempo.exe -config.file=config.yaml`