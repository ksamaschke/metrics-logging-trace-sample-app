# How to install on Windows

1. Download from https://github.com/grafana/loki/releases > loki-windows-amd64.exe.zip
2. Extract to `C:\loki`.
3. Copy the provided `config.yaml` file to said directory.
4. Execute

```powershell
mkdir C:\loki\data, 
C:\loki\chunks, 
C:\loki\index, 
C:\loki\boltdb-cache, 
C:\loki\compactor,
C:\loki\rules
```

# How to start on Windows

1. Navigate to `C:\loki` in Console / Terminal.
2. Start via `loki-windows-amd64.exe`.